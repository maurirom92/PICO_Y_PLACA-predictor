package concurso;
/*
 Schedule Pico y Placa in Quito-Ecuador

the schedule is applied according to the last digit of the plate
Monday:    1 and 2
Tuesday:   3 and 4
Wednesday: 5 and 6
Thursday:  7 and 8
Friday:    9 and 0

 */

/**
 *
 * Made by MAURICIO ANDRES ROMERO CEVALLOS
 * phone: 0987151082
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class PICO_Y_PLACA {
    
    String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numeros = "0123456789";
    int year_int = 0;
    int day_int = 0;
    int mes = 0;
    int day_of_week = 0; 
    int total_time = 0;
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;
    int cont4 = 0;
    int cont5 = 0;
    int cont6 = 0;
    int cont7 = 0; 
    int days_february = 0;
    int day_name = 0;
    int ultimo_digito = 0;
    int hour_int_transform = 0;
    int month_int = 0;    
    int hour_int = 0;
    int min_int = 0;
    String day = "";
    String month = "";
    String month_word = "";
    String year = "";
    String fill = "";
    String hour = "";
    String min = "";
    String fill2 = "";
    String day_of_week_String = ""; 
    String placa2 = "";
    
  //the code of this method is separated by 5 phases that I wrote next
    public boolean PYP(String placa1, String fecha1, String hora1){
        String placa = placa1.toUpperCase();
        String fecha = fecha1 + "/*";
        String hora = hora1 + ":*";
        
///////////////////1.- I check if it is a valid car license plate//////////////////
        if(placa.length() == 8 || placa.length() == 7){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < abecedario.length(); j++){
                    if(placa.charAt(i) == abecedario.charAt(j)){
                        cont1++;
                    } 
                }
            }
            if(placa.charAt(3) == '-'){
                cont2 = 3;
            }
            if(placa.length() == 7){
                for(int i = 4; i < 7; i++){
                    for(int j = 0; j < numeros.length(); j++){
                        if(placa.charAt(i) == numeros.charAt(j)){
                            cont3++;
                            if(cont3 == 3){
                                cont3 = 4;
                            }
                        } 
                    }
                }
            }
            
            else if(placa.length() == 8){
                for(int i = 4; i < 8; i++){
                    for(int j = 0; j < numeros.length(); j++){
                        if(placa.charAt(i) == numeros.charAt(j)){
                            cont3++;
                        }
                    } 
                }
            }

            if(cont1 == cont2 && cont3 == 4){
                cont4 = 1;
                placa2 = placa;
            } 
            else{
                System.out.println("IT IS NOT A VALID LICENSE PLATE NUMBER, TRY AGAIN");
                INPUTS();
            }   
        }
        else{
            System.out.println("IT IS NOT A VALID LICENSE PLATE NUMBER, TRY AGAIN"); 
            INPUTS();
        }
/////END///////////////////////////////////////////////////////////////////////////


///////2.- I separate the string from the date to convert it to an integer///////////
        if(cont4 == 1){
            for(int i = 0; i < fecha.length(); i++){
                if(fecha.charAt(i) == '/'){
                     fecha = fecha.substring(i+1, fecha.length());
                     cont5++;
                     if(cont5 == 1){
                         day = fill;
                     }
                     else if(cont5 == 2){
                         month = fill;
                     }
                     else if(cont5 == 3){
                         year = fill;
                     }
                     fill = "";
                     i = 0;
                }
                fill = fill + fecha.charAt(i);
            }
            cont4 = 2;
        }
//////END//////////////////////////////////////////////////////////////////////////
        
        
////////////3.- I convert the date to integer numbers, and name the months//////////
        if(cont4 == 2){
            
            day_int = Integer.parseInt(day);
            month_int = Integer.parseInt(month);
            year_int = Integer.parseInt(year);
        
            if(year_int < 2013){
                System.out.println("Pico y Placa WAS IMPLEMENTED SINCE 2013, TRY AGAIN");
                INPUTS();
            }
            
            else{
                //algorithm to calculate how many days February will have
                for(int i = 2008; i <= year_int; i++){
                    if(cont6 == 4){
                        days_february = 29;
                        cont6 = 0;
                    }
                    else{
                        days_february = 28;
                    }
                    cont6++;
                }
        
                if(month_int == 1 && day_int <= 31){
                    mes = Calendar.JANUARY; 
                    DayOfWeek();
                    month_word = "January";
                }
                else if(month_int == 2 && day_int <= days_february){
                    mes = Calendar.FEBRUARY;  
                    DayOfWeek();
                    month_word = "February";
                }
                else if(month_int == 3 && day_int <= 31){
                    mes = Calendar.MARCH;  
                    DayOfWeek();
                    month_word = "March";
                }
                else if(month_int == 4 && day_int <= 30){
                    mes = Calendar.APRIL; 
                    DayOfWeek();
                    month_word = "April";
                }
                else if(month_int == 5 && day_int <= 31){
                    mes = Calendar.MAY;
                    DayOfWeek();
                    month_word = "May";
                }
                else if(month_int == 6 && day_int <= 30){
                    mes = Calendar.JUNE;
                    DayOfWeek();
                    month_word = "June";
                } 
                else if(month_int == 7 && day_int <= 31){
                    mes = Calendar.JULY; 
                    DayOfWeek();
                    month_word = "July";
                }
                else if(month_int == 8 && day_int <= 31){
                    mes = Calendar.AUGUST; 
                    DayOfWeek();
                    month_word = "August";
                }
                else if(month_int == 9 && day_int <= 30){
                    mes = Calendar.SEPTEMBER; 
                    DayOfWeek();
                    month_word = "September";
                }
                else if(month_int == 10 && day_int <= 31){
                    mes = Calendar.OCTOBER; 
                    DayOfWeek();
                    month_word = "Octover";
                }
                else if(month_int == 11 && day_int <= 30){
                    mes = Calendar.NOVEMBER; 
                    DayOfWeek();
                    month_word = "November";
                }
                else if(month_int == 12 && day_int <= 31){
                    mes = Calendar.DECEMBER; 
                    DayOfWeek();
                    month_word = "December";
               }
                else{
                    System.out.println("IT IS NOT A VALID DATE, TRY AGAIN");
                    INPUTS();
                }
                
            }
            
        
        }   
/////////END//////////////////////////////////////////////////////////////////////
        
        
////////////4.- I separate the string of time and convert them to integers/////////
        if(cont4 == 3){

            for(int i = 0; i < hora.length(); i++){
                if(hora.charAt(i) == ':'){
                     hora = hora.substring(i+1, hora.length());
                     cont7++;
                     if(cont7 == 1){
                         hour = fill2;
                     }
                     else if(cont7 == 2){
                         min = fill2;
                     }
                     fill2 = "";
                     i = 0;
                }
                fill2 = fill2 + hora.charAt(i);
            }
           
            hour_int = Integer.parseInt(hour);
            min_int = Integer.parseInt(min);
            
            if(hour_int <= 23 && min_int <= 59){
                hour_int_transform = hour_int*60;
                total_time = hour_int_transform + min_int;
                cont4 = 4;
            }
            else{
                System.out.println("IT IS NOT A VALID TIME, TRY AGAIN");
                INPUTS();
            }
        }
  ///////END///////////////////////////////////////////////////////////////////////
  
  
  //////////////////5.- I make the comparison of days, plate number, time////////////
        if(cont4 == 4){  
         
            if((day_of_week == 2 && placa.charAt(placa.length()-1) == '1') || (day_of_week == 2 && placa.charAt(placa.length()-1) == '2')){
                if((total_time >= 420 && total_time <= 570) || (total_time >= 960 && total_time <= 1170)){
                    System.out.println("NO, CAN NOT DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN NOT DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return false;
                }
                else{
                    System.out.println("YES, CAN DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return true;
                }
            }
            else if((day_of_week == 3 && placa.charAt(placa.length()-1) == '3') || (day_of_week == 3 && placa.charAt(placa.length()-1) == '4')){
                if((total_time >= 420 && total_time <= 570) || (total_time >= 960 && total_time <= 1170)){
                    System.out.println("NO, CAN NOT DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN NOT DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return false;
                }
                else{
                    System.out.println("YES, CAN DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return true;
                }
            }
            else if((day_of_week == 4 && placa.charAt(placa.length()-1) == '5') || (day_of_week == 4 && placa.charAt(placa.length()-1) == '6')){
                if((total_time >= 420 && total_time <= 570) || (total_time >= 960 && total_time <= 1170)){
                    System.out.println("NO, CAN NOT DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN NOT DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return false;
                }
                else{
                    System.out.println("YES, CAN DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return true;
                }
            }
            else if((day_of_week == 5 && placa.charAt(placa.length()-1) == '7') || (day_of_week == 5 && placa.charAt(placa.length()-1) == '8')){
                if((total_time >= 420 && total_time <= 570) || (total_time >= 960 && total_time <= 1170)){
                    System.out.println("NO, CAN NOT DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN NOT DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return false;
                }
                else{
                    System.out.println("YES, CAN DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return true;
                }
            }
            else if((day_of_week == 6 && placa.charAt(placa.length()-1) == '9') || (day_of_week == 6 && placa.charAt(placa.length()-1) == '0')){
                if((total_time >= 420 && total_time <= 570) || (total_time >= 960 && total_time <= 1170)){
                    System.out.println("NO, CAN NOT DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN NOT DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return false;
                }
                else{
                    System.out.println("YES, CAN DRIVE");
                    System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                    return true;
                }
            }
            else{
                System.out.println("YES, CAN DRIVE");
                System.out.println("the car with license plate number " + placa2 + " CAN DRIVE " + "on " + day_of_week_String + ", " + month_word + " " + day + ", " + year + " at " +  hour + ":" + min + " in Quito-Ecuador");
                return true;
            }
        }
 //////////END/////////////////////////////////////////////////////////////////////   
        return false;
    }
    
    
    //in this function I put a name on the days of the week
    public void DayOfWeek(){
        Calendar calendario = new GregorianCalendar(year_int, mes, day_int);
        day_of_week = calendario.get(Calendar.DAY_OF_WEEK);
        cont4 = 3;  
        if(day_of_week == 1){
            day_of_week_String = "Sunday";
        }
        if(day_of_week == 2){
            day_of_week_String = "Monday";
        }
        if(day_of_week == 3){
            day_of_week_String = "Tuesday";
        }
        if(day_of_week == 4){
            day_of_week_String = "Wednesday";
        }
        if(day_of_week == 5){
            day_of_week_String = "Thursday";
        }
        if(day_of_week == 6){
            day_of_week_String = "Friday";
        }
        if(day_of_week == 7){
            day_of_week_String = "Saturday";
        }
    }
    

    //in this method we enter the inputs and the answer to the main method
    public boolean INPUTS(){
        Scanner x = new Scanner(System.in);
        String placa1;
        String fecha1;
        String hora1;
        System.out.println("");
        System.out.println("");
        System.out.println("////////////////////////////////////////////////////////////////////////////");
        System.out.println("Write a valid license plate number //EXAMPLE 1: PVT-354, EXAMPLE 2: PVT-3540");
        placa1 = x.next();
        System.out.println("");
        
        System.out.println("Write the date //EXAMPLE: 15/01/2020");
        fecha1 = x.next();
        System.out.println("");
        
        System.out.println("Write the time //EXAMPLE: 07:30");
        hora1 = x.next();
        System.out.println("");
        PICO_Y_PLACA deliver = new PICO_Y_PLACA();
        boolean momo = deliver.PYP(placa1, fecha1, hora1);
        
        if(momo == true){
            return true; 
        }
        else{
            return false;
        }
    }
    
    //principal class
    public static void main(String[] args) {
        PICO_Y_PLACA mensajero = new PICO_Y_PLACA();
        //if answer is true the car can drive, and if it is false the car can not drive
        boolean answer = mensajero.INPUTS();
        
        if(answer == false){
            System.out.println(answer + ": This is the response of the Boolean variable that indicates that you can not drive");
        }
        if(answer == true){
            System.out.println(answer + ": This is the response of the Boolean variable that indicates that you can drive");
        }
        
    }
}
