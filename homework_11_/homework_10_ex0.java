package com.tms.homework_11_;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class homework_10_ex0 {
static String p="docnum";
    public static void main(String[] args)  {
        System.out.println("Введите путь потока ввода: ");
        Scanner scanner= new Scanner(System.in);
        String path= scanner.nextLine();
        Pattern pattern=Pattern.compile(p);
        
        try(BufferedReader fr=new BufferedReader(new FileReader(path));
        BufferedWriter fw= new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\TMS_11_ HOMEWORK\\ValidDocumentNumbers.txt"));
        BufferedWriter fw2= new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\TMS_11_ HOMEWORK\\InvalidDocumentNumbers.txt"))) {
            String line ;
            while ((line= fr.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (line.length() == 21 && matcher.find()) {

                    fw.write(" Номер документа валиден - " + line);
                    fw.write("\n");

                } else {
                    fw2.write(" Номер документа не валиден - " + line);
                    fw2.write("\n");

                }

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

