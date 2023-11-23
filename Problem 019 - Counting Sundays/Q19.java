
/* <p>You are given the following information, but you may prefer to do some research for yourself.</p>
<ul><li>1 Jan 1900 was a Monday.</li>
<li>Thirty days has September,<br />
April, June and November.<br />
All the rest have thirty-one,<br />
Saving February alone,<br />
Which has twenty-eight, rain or shine.<br />
And on leap years, twenty-nine.</li>
<li>A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.</li>
</ul><p>How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?</p>
 */

// i realize this is dogshit and there's no need to actually iterate day by day, could have just added the lump amount of days in the months mod7
// oh well it works hehe

public class Q19 {

    public static void main(String[] args) throws Exception{

        int[] daysPerMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysPerMonthLeapYear = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // our first day is January 1, 1901, a Monday

        int dayOfTheMonth = 0;
        int weekday = 0;
        int month = 0;
        int year = 1901;
        int sundayFirsts = 0;

        for (;year<=2000;year++) {

            if (year%4==0 && !(year%100==0 && year%400!=0)) { // leap year case

                for (month = 0;month<=11;month++) {

                    for (dayOfTheMonth = 1;dayOfTheMonth <= daysPerMonthLeapYear[month];dayOfTheMonth++) {
                        weekday = (weekday+1)%7;
                        if (dayOfTheMonth == 1 & days[weekday].equals("Sunday")) {
                            sundayFirsts = sundayFirsts+1;
                        }
                    }
                }
            }

            else { // non leap year case

                for (month = 0;month<=11;month++) {

                    for (dayOfTheMonth = 1;dayOfTheMonth <= daysPerMonth[month];dayOfTheMonth++) {
                        weekday = (weekday+1)%7;

                        if (dayOfTheMonth == 1 & days[weekday].equals("Sunday")) {
                            sundayFirsts = sundayFirsts+1;
                        }
                    }

                }
            }

        }

        System.out.println(sundayFirsts);
    }
}