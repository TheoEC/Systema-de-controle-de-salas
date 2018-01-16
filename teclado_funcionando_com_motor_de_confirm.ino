
#include <Servo.h>
#define SERVO 11 // Porta Digital 11 PWM

Servo s; // Variável Servo
int pos; // Posição Servo


void setup()
{
  //Pinos ligados aos pinos 1, 2, 3 e 4 do teclado - Linhas
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  
  //Pinos ligados aos pinos 5, 6, 7 e 8 do teclado - Colunas
  pinMode(8, INPUT);
  pinMode(9, INPUT);
  pinMode(10, INPUT);
  pinMode(11, INPUT);
  
  Serial.begin(9600);
  Serial.println("Aguardando acionamento das teclas...");
  Serial.println();
  
  s.attach(SERVO);
  Serial.begin(9600);
  s.write(0); // Inicia motor posição zero
}
 
String pega_senha(){
  String senha;
  int digitos_pegos = 0;
  
  while (digitos_pegos < 4) {
    for (int ti = 3; ti<7; ti++){
    //Alterna o estado dos pinos das linhas
    digitalWrite(3, LOW);
    digitalWrite(4, LOW);
    digitalWrite(5, LOW);
    digitalWrite(6, LOW);
    digitalWrite(ti, HIGH);
    
    //Verifica se alguma tecla da coluna 1 foi pressionada
    if (digitalRead(8) == HIGH){
      senha += pega_numero(ti-2, 1);
      digitos_pegos += 1;
      while(digitalRead(8) == HIGH){}
    }
 
    //Verifica se alguma tecla da coluna 2 foi pressionada    
    if (digitalRead(9) == HIGH){
      senha += pega_numero(ti-2, 2);
      digitos_pegos += 1;
      while(digitalRead(9) == HIGH){};
    }
    
    //Verifica se alguma tecla da coluna 3 foi pressionada
    if (digitalRead(10) == HIGH) {
      senha += pega_numero(ti-2, 3);
      digitos_pegos += 1;
      while(digitalRead(10) == HIGH){}
    }
    
    //Verifica se alguma tecla da coluna 4 foi pressionada
    
   }
   delay(100);
  }
  Serial.println(senha);
  return senha;
}
 
char pega_numero(int x, int y){
       if (x == 1 && y == 1){

        return('1');
       }

       else if (x == 1 && y == 2){
        return('2');
       }
       
       else if (x == 1 && y == 3){

        return('3');
       }

       else if (x == 2 && y == 1){

        return('4');
       }
       
       else if (x == 2 && y == 2){

        return('5');
       }
       
       else if (x == 2 && y == 3){
        return('6');

       }
       
       else if (x == 3 && y == 1){
        return('7');

       }
       
       else if (x == 3 && y == 2){
        return('8');

       }
       
       else if (x == 3 && y == 3){
        return('9');

       }
       
       else if (x == 4 && y == 1){
        return('*');
       }
       
       else if (x == 4 && y == 2){
        return('0');
       }
       
       else if (x == 4 && y == 3){
        return('#');
       }

       else {
        Serial.print(x);
        Serial.print(y);
        return('R');
       }
}

void loop(){
  String b;
  b = pega_senha();
  delay(500);
  
  for(pos = 0; pos < 90; pos++){
    s.write(pos);
  delay(15);
  }
  
  delay(500);
  
  for(pos = 90; pos >= 0; pos--){
    s.write(pos);
    delay(15);
  }
  
}

