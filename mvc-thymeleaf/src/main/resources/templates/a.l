%option noyywrap
%%
^(.)*$ printf ("Ligne /n ");
%%
 void main(){
     yylex();

 }