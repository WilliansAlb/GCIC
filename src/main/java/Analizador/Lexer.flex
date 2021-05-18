package Analizador;

import java_cup.runtime.Symbol;
import org.apache.commons.lang3.StringUtils;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%unicode
%line
%column
%char
%public
L=[a-zA-Z]+
L2=[a-zA-Z]
ID = [a-zA-Z]([a-zA-Z]|"_"|[0-9])*
D= [1-9][0-9]*
H=#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
DEC = ([0-9]|[1-9][0-9]*)["."][0-9]?[0-9]?[0-9]?[1-9]
C=[@_"-"%#&:]+
C2=[@_%#&:.]+
C3=["[""]""!"#$%&"'""("")""*""+",/:;="-"_~"?"@.]
espacio=[\t|\r|\n]+
esp = [" "]+
gcic = [Cc][_][Gg][Cc][Ii][Cc]
head = [Cc][_][Hh][Ee][Aa][Dd]
title = [Cc][_][Tt][Ii][Tt][Ll][Ee]
link = [Cc][_][Ll][Ii][Nn][Kk]
body = [Cc][_][Bb][Oo][Dd][Yy]
spam = [Cc][_][Ss][Pp][Aa][Mm]
input = [Cc][_][Ii][Nn][Pp][Uu][Tt]
textarea = [Cc][_][Tt][Ee][Xx][Tt][Aa][Rr][Ee][Aa]
select = [Cc][_][Ss][Ee][Ll][Ee][Cc][Tt]
option = [Cc][_][Oo][Pp][Tt][Ii][Oo][Nn]
div = [Cc][_][Dd][Ii][Vv]
img = [Cc][_][Ii][Mm][Gg]
br = [Cc][_][Bb][Rr]
button = [Cc][_][Bb][Uu][Tt][Tt][Oo][Nn]
h1 = [Cc][_][Hh][1]
p = [Cc][_][Pp]
script = [Cc][_][Ss][Cc][Rr][Ii][Pp][Tt][Ii][Nn][Gg]
url = ("https://")?{L}({L})*"."{L}({L})*"."{L}({L})*"/"?(({L}|{D}|{C3})*("/")?)*
%state STRING,COMENT_LINE,MULTI_COMENT,COMENT_LINE2,MULTI_COMENT2,COMENT_LINE3,MULTI_COMENT3,TEXTO,ETIQUETA,CARACTER,SCRIPTING,PARAMETROS,PARAMETROS2
%state TEXTO2
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* palabras reservadas */
<YYINITIAL> {gcic}                 {return new Symbol(sym.GCIC, yycolumn, yyline, yytext());}
<YYINITIAL> {head}                 {return new Symbol(sym.HEAD, yycolumn, yyline, yytext());}
<YYINITIAL> {title}                 {return new Symbol(sym.TITLE, yycolumn, yyline, yytext());}
<YYINITIAL> {link}                 {return new Symbol(sym.LINK, yycolumn, yyline, yytext());}
<YYINITIAL> {body}                 {return new Symbol(sym.BODY, yycolumn, yyline, yytext());}
<YYINITIAL> {spam}                 {return new Symbol(sym.SPAM, yycolumn, yyline, yytext());}
<YYINITIAL> {input}                 {return new Symbol(sym.INPUT, yycolumn, yyline, yytext());}
<YYINITIAL> {textarea}                { return new Symbol(sym.TEXTAREA, yycolumn, yyline, yytext());}
<YYINITIAL> {select}                {return new Symbol(sym.SELECT,yycolumn,yyline,yytext());}
<YYINITIAL> {option}                {return new Symbol(sym.OPTION,yycolumn,yyline,yytext());}
<YYINITIAL> {div}                 {return new Symbol(sym.DIV,yycolumn,yyline,yytext());}
<YYINITIAL> {img}                 {return new Symbol(sym.IMG,yycolumn,yyline,yytext());}
<YYINITIAL> {br}          {return new Symbol(sym.BR, yycolumn, yyline, yytext());}
<YYINITIAL> {button}               {return new Symbol(sym.BUTTON,yycolumn,yyline,yytext());}
<YYINITIAL> {h1}            {return new Symbol(sym.H1, yycolumn, yyline, yytext());}
<YYINITIAL> {p}              {return new Symbol(sym.P, yycolumn, yyline, yytext());}
<YYINITIAL> {script}              {yybegin(SCRIPTING);return new Symbol(sym.SCRIPT, yycolumn, yyline, yytext());}
<YYINITIAL> "ON_LOAD"              {return new Symbol(sym.ONLOAD, yycolumn, yyline, yytext());}
<YYINITIAL> "href"              {return new Symbol(sym.HREF, yycolumn, yyline, yytext());}
<YYINITIAL> "background"              {return new Symbol(sym.BG, yycolumn, yyline, yytext());}
<YYINITIAL> "color"              {return new Symbol(sym.COLOR, yycolumn, yyline, yytext());}
<YYINITIAL> "font-size"              {return new Symbol(sym.FTS, yycolumn, yyline, yytext());}
<YYINITIAL> "font-family"              {return new Symbol(sym.FTF, yycolumn, yyline, yytext());}
<YYINITIAL> "text-align"              {return new Symbol(sym.TXTA, yycolumn, yyline, yytext());}
<YYINITIAL> "type"              {return new Symbol(sym.TYPE, yycolumn, yyline, yytext());}
<YYINITIAL> "id"              {return new Symbol(sym.ID, yycolumn, yyline, yytext());}
<YYINITIAL> "name"              {return new Symbol(sym.NAME, yycolumn, yyline, yytext());}
<YYINITIAL> "cols"              {return new Symbol(sym.COLS, yycolumn, yyline, yytext());}
<YYINITIAL> "rows"              {return new Symbol(sym.ROWS, yycolumn, yyline, yytext());}
<YYINITIAL> "class"              {return new Symbol(sym.CLASS, yycolumn, yyline, yytext());}
<YYINITIAL> "src"              {return new Symbol(sym.SRC, yycolumn, yyline, yytext());}
<YYINITIAL> "width"              {return new Symbol(sym.WIDTH, yycolumn, yyline, yytext());}
<YYINITIAL> "height"              {return new Symbol(sym.HEIGHT, yycolumn, yyline, yytext());}
<YYINITIAL> "alt"              {return new Symbol(sym.ALT, yycolumn, yyline, yytext());}
<YYINITIAL> "onclick"              {return new Symbol(sym.ONC, yycolumn, yyline, yytext());}
<YYINITIAL> ("@global")              {return new Symbol(sym.MODO, yycolumn, yyline, yytext());}
<YYINITIAL> ("\"")              {yybegin(PARAMETROS); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
<YYINITIAL> ("!!")              {yybegin(COMENT_LINE);}
<YYINITIAL> ("<!--")              {yybegin(MULTI_COMENT);}
<YYINITIAL> "("              {return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
<YYINITIAL> ")"              {return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
<YYINITIAL> "["              {return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
<YYINITIAL> "]"              {return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
<YYINITIAL> ">"              {yybegin(TEXTO); return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());}
<YYINITIAL> "="              {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> "<"              {return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
<YYINITIAL> "</"              {return new Symbol(sym.FINETIQUETA, yycolumn, yyline, yytext());}
<YYINITIAL> "=="              {return new Symbol(sym.COMP_IGUAL, yycolumn, yyline, yytext());}
<YYINITIAL> "!="              {return new Symbol(sym.COMP_DIF, yycolumn, yyline, yytext());}
<YYINITIAL> "<="              {return new Symbol(sym.COMP_MENOR, yycolumn, yyline, yytext());}
<YYINITIAL> "=>"              {return new Symbol(sym.COMP_MAYOR, yycolumn, yyline, yytext());}
<YYINITIAL> "||"              {return new Symbol(sym.OR, yycolumn, yyline, yytext());}
<YYINITIAL> "&&"              {return new Symbol(sym.AND, yycolumn, yyline, yytext());}
<YYINITIAL> "!"              {return new Symbol(sym.NOT, yycolumn, yyline, yytext());}
<YYINITIAL> "+"              {return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
<YYINITIAL> "-"              {return new Symbol(sym.MENOS, yycolumn, yyline, yytext());}
<YYINITIAL> "*"              {return new Symbol(sym.POR, yycolumn, yyline, yytext());}
<YYINITIAL> "/"              {return new Symbol(sym.ENTRE, yycolumn, yyline, yytext());}
<YYINITIAL> "ASC"              {return new Symbol(sym.ASC, yycolumn, yyline, yytext());}
<YYINITIAL> "DESC"              {return new Symbol(sym.DESC, yycolumn, yyline, yytext());}
<YYINITIAL> "LETPAR_NUM"              {return new Symbol(sym.FPAR, yycolumn, yyline, yytext());}
<YYINITIAL> "LETIMPAR_NUM"              {return new Symbol(sym.FIMPAR, yycolumn, yyline, yytext());}
<YYINITIAL> "REVERSE"              {return new Symbol(sym.REVERSE, yycolumn, yyline, yytext());}
<YYINITIAL> "CARACTER_ALEATORIO"              {return new Symbol(sym.FCARACTER, yycolumn, yyline, yytext());}
<YYINITIAL> "NUM_ALEATORIO"              {return new Symbol(sym.FNUM, yycolumn, yyline, yytext());}
<YYINITIAL> "ALERT_INFO"              {return new Symbol(sym.ALERT, yycolumn, yyline, yytext());}
<YYINITIAL> "EXIT"              {return new Symbol(sym.EXIT, yycolumn, yyline, yytext());}
<YYINITIAL> "integer"              {return new Symbol(sym.INT, yycolumn, yyline, yytext());}
<YYINITIAL> "boolean"              {return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
<YYINITIAL> "string"              {return new Symbol(sym.STRINGD, yycolumn, yyline, yytext());}
<YYINITIAL> "decimal"              {return new Symbol(sym.DECIMALD, yycolumn, yyline, yytext());}
<YYINITIAL> "char"              {return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
<YYINITIAL> "'"                 {return new Symbol(sym.APOS, yycolumn, yyline, yytext());}
<YYINITIAL> "getElementById"              {return new Symbol(sym.GET_ELEMENT, yycolumn, yyline, yytext());}
<YYINITIAL> ";"              {return new Symbol(sym.PUNTOC, yycolumn, yyline, yytext());}
<YYINITIAL> "INIT"              {return new Symbol(sym.INIT, yycolumn, yyline, yytext());}
<YYINITIAL> "{"              {return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}
<YYINITIAL> "}"              {return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext());}
<YYINITIAL> ":"              {return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
<YYINITIAL> "IF"              {return new Symbol(sym.IF, yycolumn, yyline, yytext());}
<YYINITIAL> "ELSE"              {return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
<YYINITIAL> "THEN"              {return new Symbol(sym.THEN, yycolumn, yyline, yytext());}
<YYINITIAL> "REPEAT"              {return new Symbol(sym.REPEAT, yycolumn, yyline, yytext());}
<YYINITIAL> "HUNTIL"              {return new Symbol(sym.HUNTIL, yycolumn, yyline, yytext());}
<YYINITIAL> "WHILE"              {return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
<YYINITIAL> "THENWHILE"              {return new Symbol(sym.THENW, yycolumn, yyline, yytext());}
<YYINITIAL> "INSERT"              {return new Symbol(sym.INSERT, yycolumn, yyline, yytext());}
<YYINITIAL> "REDIRECT"              {return new Symbol(sym.REDIRECT, yycolumn, yyline, yytext());}
<PARAMETROS>{
    ("\"")                      {yybegin(YYINITIAL); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
    "("              {return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
    ")"              {return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
    {H}                         {return new Symbol(sym.HEX, yycolumn, yyline, yytext());}
    ("-")?{D}                        {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {D}("px")                 {return new Symbol(sym.PIXELS, yycolumn, yyline, yytext());}
    {D}("%")                  {return new Symbol(sym.PORC, yycolumn, yyline, yytext());}
    ("-")?{DEC}                        {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    ("black"|"olive"|"teal"|"red"|"blue"|"maroon"|"navy"|"gray"|"lime"|"fucsia"|"green"|"white"|"green"|"purple"|"silver"|"yellow"|"aqua")              {return new Symbol(sym.COLORES, yycolumn, yyline, yytext());}
    ("Courier"|"Verdana"|"Arial"|"Geneva"|"sans-serif")              {return new Symbol(sym.FUENTES, yycolumn, yyline, yytext());}
    ("center"|"left"|"right"|"justify")              {return new Symbol(sym.ALIGN, yycolumn, yyline, yytext());}
    ("text"|"number"|"radio"|"checkbox")              {return new Symbol(sym.TIPOS, yycolumn, yyline, yytext());}
    ("row"|"column")              {return new Symbol(sym.CLASE, yycolumn, yyline, yytext());}
    "PROCESS_"{ID}                       {return new Symbol(sym.PROCESS, yycolumn, yyline, yytext());}
    {ID}                        {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
    {url}                       {return new Symbol(sym.URL, yycolumn, yyline, yytext());}
    [^\""("")"]+                {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
}

<PARAMETROS2>{
    ("\"")                      {yybegin(ETIQUETA); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
    "("              {return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
    ")"              {return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
    {H}                         {return new Symbol(sym.HEX, yycolumn, yyline, yytext());}
    ("-")?{D}                        {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {D}("px")                 {return new Symbol(sym.PIXELS, yycolumn, yyline, yytext());}
    {D}("%")                  {return new Symbol(sym.PORC, yycolumn, yyline, yytext());}
    ("-")?{DEC}                        {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    ("black"|"olive"|"teal"|"red"|"blue"|"maroon"|"navy"|"gray"|"lime"|"fucsia"|"green"|"white"|"green"|"purple"|"silver"|"yellow"|"aqua")              {return new Symbol(sym.COLORES, yycolumn, yyline, yytext());}
    ("Courier"|"Verdana"|"Arial"|"Geneva"|"sans-serif")              {return new Symbol(sym.FUENTES, yycolumn, yyline, yytext());}
    ("center"|"left"|"right"|"justify")              {return new Symbol(sym.ALIGN, yycolumn, yyline, yytext());}
    ("text"|"number"|"radio"|"checkbox")              {return new Symbol(sym.TIPOS, yycolumn, yyline, yytext());}
    ("row"|"column")              {return new Symbol(sym.CLASE, yycolumn, yyline, yytext());}
    {ID}                        {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
    {url}                       {return new Symbol(sym.URL, yycolumn, yyline, yytext());}
    [^\"]                       {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
}

<TEXTO>{
    ("<")                       {yybegin(YYINITIAL); return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
    ("</")                       {yybegin(YYINITIAL); return new Symbol(sym.FINETIQUETA, yycolumn, yyline, yytext());}
    ("!!")                      {yybegin(COMENT_LINE3);}
    ("<!--")                    {yybegin(MULTI_COMENT3);}
    [^"!!""<""</"]+             {if (!StringUtils.isBlank(yytext())) return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
    
{esp} {/*ignore*/}
{espacio}           {/*Ignore*/}
}

<TEXTO2>{
    ("<")                       {yybegin(ETIQUETA); return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
    ("</")                       {yybegin(ETIQUETA); return new Symbol(sym.FINETIQUETA, yycolumn, yyline, yytext());}
    ("'")                       {yybegin(SCRIPTING); return new Symbol(sym.APOS, yycolumn, yyline, yytext());}
    [^"'""<""</"]+             {if (!StringUtils.isBlank(yytext())) return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
    {espacio}           {/*Ignore*/}
    {esp}           {/*Ignore*/}
}

<STRING>{
    ("\"")                      {yybegin(SCRIPTING); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
    [^"\""]+                       {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
}

<CARACTER>{
    ("'")                      {yybegin(SCRIPTING); return new Symbol(sym.APOS, yycolumn, yyline, yytext());}
    "<"                        {yybegin(ETIQUETA); return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
    {L2}                       {return new Symbol(sym.OCHAR, yycolumn, yyline, yytext()); }
    {ID}                       {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
    {espacio}           {/*Ignore*/}
    [^"'""<"]+                        {return new Symbol(sym.STRING, yycolumn, yyline, yytext());}
}

<ETIQUETA>{
    "'"                     {yybegin(SCRIPTING); return new Symbol(sym.APOS, yycolumn, yyline, yytext());}
    ">"                     {yybegin(TEXTO2);return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());}
    "</"                     {return new Symbol(sym.FINETIQUETA, yycolumn, yyline, yytext());}
    "="                     {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
    "["                     {return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
    "]"                     {return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
    {title}                 {return new Symbol(sym.TITLE, yycolumn, yyline, yytext());}
    {link}                 {return new Symbol(sym.LINK, yycolumn, yyline, yytext());}
    {spam}                 {return new Symbol(sym.SPAM, yycolumn, yyline, yytext());}
    {input}                 {return new Symbol(sym.INPUT, yycolumn, yyline, yytext());}
    {textarea}                { return new Symbol(sym.TEXTAREA, yycolumn, yyline, yytext());}
    {select}                {return new Symbol(sym.SELECT,yycolumn,yyline,yytext());}
    {option}                {return new Symbol(sym.OPTION,yycolumn,yyline,yytext());}
    {div}                 {return new Symbol(sym.DIV,yycolumn,yyline,yytext());}
    {img}                 {return new Symbol(sym.IMG,yycolumn,yyline,yytext());}
    {br}          {return new Symbol(sym.BR, yycolumn, yyline, yytext());}
    {button}               {return new Symbol(sym.BUTTON,yycolumn,yyline,yytext());}
    {h1}            {return new Symbol(sym.H1, yycolumn, yyline, yytext());}
    {p}              {return new Symbol(sym.P, yycolumn, yyline, yytext());}
    "href"              {return new Symbol(sym.HREF, yycolumn, yyline, yytext());}
    "background"              {return new Symbol(sym.BG, yycolumn, yyline, yytext());}
    "color"              {return new Symbol(sym.COLOR, yycolumn, yyline, yytext());}
    "font-size"              {return new Symbol(sym.FTS, yycolumn, yyline, yytext());}
    "font-family"              {return new Symbol(sym.FTF, yycolumn, yyline, yytext());}
    "text-align"              {return new Symbol(sym.TXTA, yycolumn, yyline, yytext());}
    "type"              {return new Symbol(sym.TYPE, yycolumn, yyline, yytext());}
    "id"              {return new Symbol(sym.ID, yycolumn, yyline, yytext());}
    "name"              {return new Symbol(sym.NAME, yycolumn, yyline, yytext());}
    "cols"              {return new Symbol(sym.COLS, yycolumn, yyline, yytext());}
    "rows"              {return new Symbol(sym.ROWS, yycolumn, yyline, yytext());}
    "class"              {return new Symbol(sym.CLASS, yycolumn, yyline, yytext());}
    "src"              {return new Symbol(sym.SRC, yycolumn, yyline, yytext());}
    "width"              {return new Symbol(sym.WIDTH, yycolumn, yyline, yytext());}
    "height"              {return new Symbol(sym.HEIGHT, yycolumn, yyline, yytext());}
    "alt"              {return new Symbol(sym.ALT, yycolumn, yyline, yytext());}
    "onclick"              {return new Symbol(sym.ONC, yycolumn, yyline, yytext());}
    ("\"")              {yybegin(PARAMETROS2); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
{esp} {/*ignore*/}
{espacio}           {/*Ignore*/}
}

<COMENT_LINE>{
    ("\n")                      {yybegin(YYINITIAL);}
    [^"\n"]                       { }
}

<MULTI_COMENT>{
    ("-->")                      {yybegin(YYINITIAL);}
    [^"-->"]                       { }
}

<COMENT_LINE3>{
    ("\n")                      {yybegin(TEXTO);}
    [^"\n"]+                       { }
}

<MULTI_COMENT3>{
    ("-->")                      {yybegin(TEXTO);}
    [^"-->"]+                       { }
}

<COMENT_LINE2>{
    ("\n")                      {yybegin(SCRIPTING);}
    [^"\n"]                       { }
}

<MULTI_COMENT2>{
    ("-->")                      {yybegin(SCRIPTING);}
    [^"-->"]                       { }
}

<SCRIPTING>{
    {script}                    {yybegin(YYINITIAL);return new Symbol(sym.SCRIPT, yycolumn, yyline, yytext());}
    ("'")                       {yybegin(CARACTER); return new Symbol(sym.APOS, yycolumn, yyline, yytext());}
    ("\"")                      {yybegin(STRING); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
    (",")                       {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    ("!!")                      {yybegin(COMENT_LINE2);}
    ("<!--")                    {yybegin(MULTI_COMENT2);}
    "="                         {return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
    "=="                        {return new Symbol(sym.COMP_IGUAL, yycolumn, yyline, yytext());}
    ">"                         {return new Symbol(sym.MAYORQ, yycolumn, yyline, yytext());}
    "<"                         {return new Symbol(sym.MENORQ, yycolumn, yyline, yytext());}
    "</"                         {return new Symbol(sym.FINETIQUETA, yycolumn, yyline, yytext());}
    "!="                        {return new Symbol(sym.COMP_DIF, yycolumn, yyline, yytext());}
    "<="                        {return new Symbol(sym.COMP_MENOR, yycolumn, yyline, yytext());}
    ">="                        {return new Symbol(sym.COMP_MAYOR, yycolumn, yyline, yytext());}
    "||"                        {return new Symbol(sym.OR, yycolumn, yyline, yytext());}
    "&&"                        {return new Symbol(sym.AND, yycolumn, yyline, yytext());}
    "!"              {return new Symbol(sym.NOT, yycolumn, yyline, yytext());}
    "+"              {return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
    "-"              {return new Symbol(sym.MENOS, yycolumn, yyline, yytext());}
    "*"              {return new Symbol(sym.POR, yycolumn, yyline, yytext());}
    "/"              {return new Symbol(sym.ENTRE, yycolumn, yyline, yytext());}
    "("              {return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
    ")"              {return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
    "["              {return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
    "]"              {return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
    "ASC"              {return new Symbol(sym.ASC, yycolumn, yyline, yytext());}
    "DESC"              {return new Symbol(sym.DESC, yycolumn, yyline, yytext());}
    "LETPAR_NUM"              {return new Symbol(sym.FPAR, yycolumn, yyline, yytext());}
    "LETIMPAR_NUM"              {return new Symbol(sym.FIMPAR, yycolumn, yyline, yytext());}
    "REVERSE"              {return new Symbol(sym.REVERSE, yycolumn, yyline, yytext());}
    "CARACTER_ALEATORIO"              {return new Symbol(sym.FCARACTER, yycolumn, yyline, yytext());}
    "NUM_ALEATORIO"              {return new Symbol(sym.FNUM, yycolumn, yyline, yytext());}
    "ALERT_INFO"              {return new Symbol(sym.ALERT, yycolumn, yyline, yytext());}
    "EXIT"              {return new Symbol(sym.EXIT, yycolumn, yyline, yytext());}
    "ON_LOAD"              {return new Symbol(sym.ONLOAD, yycolumn, yyline, yytext());}
    "integer"              {return new Symbol(sym.INT, yycolumn, yyline, yytext());}
    "boolean"              {return new Symbol(sym.BOOLEAND, yycolumn, yyline, yytext());}
    ("true"|"false")              {return new Symbol(sym.BOOLEAN, yycolumn, yyline, yytext());}
    "string"              {return new Symbol(sym.STRINGD, yycolumn, yyline, yytext());}
    "decimal"              {return new Symbol(sym.DECIMALD, yycolumn, yyline, yytext());}
    "char"              {return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
    "getElementById"              {return new Symbol(sym.GET_ELEMENT, yycolumn, yyline, yytext());}
    ";"              {return new Symbol(sym.PUNTOC, yycolumn, yyline, yytext());}
    "INIT"              {return new Symbol(sym.INIT, yycolumn, yyline, yytext());}
    "{"              {return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}
    "}"              {return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext());}
    ":"              {return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
    "IF"              {return new Symbol(sym.IF, yycolumn, yyline, yytext());}
    "ELSE"              {return new Symbol(sym.ELSE, yycolumn, yyline, yytext());}
    "THEN"              {return new Symbol(sym.THEN, yycolumn, yyline, yytext());}
    "REPEAT"              {return new Symbol(sym.REPEAT, yycolumn, yyline, yytext());}
    "HUNTIL"              {return new Symbol(sym.HUNTIL, yycolumn, yyline, yytext());}
    "WHILE"              {return new Symbol(sym.WHILE, yycolumn, yyline, yytext());}
    "THENWHILE"              {return new Symbol(sym.THENW, yycolumn, yyline, yytext());}
    "INSERT"              {return new Symbol(sym.INSERT, yycolumn, yyline, yytext());}
    "PROCESS_"{ID}                       {return new Symbol(sym.PROCESS, yycolumn, yyline, yytext());}
    {ID}                       {return new Symbol(sym.IDENTIFICADOR, yycolumn, yyline, yytext());}
    {D}                         {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {DEC}                         {return new Symbol(sym.DECIMAL, yycolumn, yyline, yytext());}
{esp} {/*ignore*/}
{espacio}           {/*Ignore*/}
}

{esp} {/*ignore*/}
{espacio}           {/*Ignore*/}
/* error fallback */
[^]                           { return new Symbol(sym.ERRORLEX,yycolumn,yyline,yytext()); }