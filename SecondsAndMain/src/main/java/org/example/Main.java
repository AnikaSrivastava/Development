public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) );
    }

    public static int getDaysInMonth(int month, int year){
        if(month < 1 || month > 12 || year < 1 || year > 9999)
            return -1;

        switch(month){
            case 1, 12, 3, 5, 7, 8, 10:
                return 31;
            break;
            case 2 :
            {
                if(isLeapYear(year)){
                    return 29;
                }
                else{
                    return 28;
                }
                break;
            }
            case 4, 6, 9, 11:
                return 30;
            break;
        }

        return -1;


    }
}