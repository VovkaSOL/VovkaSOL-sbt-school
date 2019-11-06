package com.sbt.javaschool.rnd.lesson1args.args;

public class ArgsParser {
    private String resStr;
    public ArgsParser ArgsToKebabStr(String[] args){
        int cnt = 0;
        resStr="Kebab style output args = ";
        for(String s : args){
            if(cnt>0) resStr+='-';//пропускаем начало
            resStr+= s.toLowerCase();
            cnt++;
        }
        resStr+= " (Все буквы в нижнем регистре, слова соединяются символом '-')";
        return this;
    }
    public ArgsParser ArgsToCamelStr(String[] args){
        resStr="Camel style output args = ";
        int cnt = 0;
        for(String s : args){
            if(cnt>0) resStr =resStr+s.substring(0, 1).toUpperCase() + s.substring(1);
            else resStr+= s;
            cnt++;
        }
        resStr+= " (Начинается с буквы в нижнем регистре, каждое следующее слово начинается с заглавной, слова пишутся слитно)";
        return this;
    }
    public ArgsParser ArgsToSnakeStr(String[] args){
        int cnt = 0;
        resStr="Snake style output args = ";
        for(String s : args){
            if(cnt>0) resStr+='_';//пропускаем начало
            resStr+= s.toLowerCase();
            cnt++;
        }
        resStr+= " (Все буквы в нижнем регистре, слова соединяются символом '_' (*VovkaSOL like style)";
        return this;
    }
    public ArgsParser ArgsToPascalStr(String[] args){
        resStr="Pascal style output args = ";
        for(String s : args){
            resStr =resStr+s.substring(0, 1).toUpperCase() + s.substring(1);
        }
        resStr+= " (Все слова начинаются с заглавной, пишутся слитно)";
        return this;
    }
    public ArgsParser ArgsToUpperCaseSnakeCaseStr(String[] args){
        resStr="Upper case snake style output args = ";
        int cnt = 0;
        for(String s : args){
            if(cnt>0) resStr+='_';//пропускаем начало
            resStr+= s.toUpperCase();
            cnt++;
        }
        resStr+= " (Все слова в верхнем регистре, соединяются символом '_')";
        return this;
    }
    public void PrintResToStdOut(){
        System.out.println(resStr);
    }
}
