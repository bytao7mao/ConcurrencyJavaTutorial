public class VolatileClass {
//    The full volatile visibility guarantee means, that when a value is written to days, then all variables visible to the thread are also written to main memory. That means, that when a value is written to days, the values of years and months are also written to main memory.
//
//    When reading the values of years, months and days you could do it like this:

    
        private int years; //this will be volatile too == will be read from main memory
        private int months; //this will be volatile too == will be read from main memory
        private volatile int days;

        public int totalDays() {
            int total = this.days;
            total += months * 30;
            total += years * 365;
            return total;
        }

        public void update(int years, int months, int days){
            this.years  = years;
            this.months = months;
            this.days   = days;
        }
}
