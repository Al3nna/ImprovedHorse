//Alenna - alenna.castaneda@oneidaihla.org
//for CTE software development 1
//instructor Mr Gross

//creating Horse class
class Horse {
    //creating attributes
    String name;
    String gender;
    int birthYear;
    int birthMonth;
    int birthDay;
    int age;
    //creating an array and allocating memory for 5 values
    String oldNames[] = new String[5];
    int numberOfNames = 0;

    //constructor
    public Horse (String horseName,String horseGender,int year,int month,int day){
        gender = horseGender; //setting gender to horseGender
        name = horseName; //setting name to horseName
        birthYear = year; //setting birthYear to year
        birthMonth = month; //setting birthMonth to month
        birthDay = day; //setting birthDay to day
    }

    //setting horse age
    public void setAge (int currentYear,int currentMonth) {
        int year = currentYear - birthYear; //checking age (not regarding months)
        int month = currentMonth - birthMonth; //checking how many months away birthMonth is
        if (month < 0) { //checking if birthMonth has already passed
            age = year - 1; //setting age if birthMonth has not passsed
        } else {
            age = year; //setting age if birthmonth has passed
        }
    }

    //changing horse age on birthday
    public void Birthday (int currentMonth,int currentDay) {
        if (currentMonth == birthMonth) { //checking if currentMonth is their birthMonth
            if (currentDay == birthDay) { //checking if currentDay is birthDay
                age++; //adding 1 to age
                System.out.println("Happy birthday, "+name+"! "+name+" turned "+age+".");
            }
        }
    }

    //changing horse's name
    public void nameChange (String newName) {
        oldNames[numberOfNames] = name; //setting last index of oldName array to name
        numberOfNames++; //adding 1 to number of names
        name = newName; //setting name to newName
    }

    //printing horse details
    public void printHorse () {
        System.out.println(name+" is a "+age+" year old "+gender+" horse");
    }
}

//creating RaceHorse subclass
class RaceHorse extends Horse {
    int goldMedals;
    int totalPrizeMoney;
    int topSpeed;
    int totalRaces;
    //constructor
    public RaceHorse(String horseName,String horseGender,int year,int month,int day,int goldMedals,int totalRaces,int topSpeed,int totalPrizeMoney) {
        super(horseName, horseGender, year, month, day);
        this.goldMedals = goldMedals;
        this.totalPrizeMoney = totalPrizeMoney;
        this.topSpeed = topSpeed;
        this.totalRaces = totalRaces;
    }
    //printing horse race stats
    public void printRaceStats() {
        System.out.println(name+" is a racehorse that has "+goldMedals+" gold medals after "+totalRaces+" races, "+totalPrizeMoney+" dollars in prize money, and a top speed of "+topSpeed+".");
    }
    //running horse in a race
    public void race(int opponentTopSpeed) {
        if (opponentTopSpeed < topSpeed) { //checking if horse is faster than opponent
            goldMedals++; //adding 1 to goldMedals
            totalPrizeMoney += 1000; //adding 1,000 to total prizeMoney
            totalRaces++; //adding 1 to totalRaces
            System.out.println(name+" won the race!");
        } else if (opponentTopSpeed == topSpeed) { //checking if horse is the same speed as opponent
            totalPrizeMoney += 500; //adding 500 to total prizeMoney
            totalRaces++; //adding 1 to totalRaces
            System.out.println("The race ended in a tie!");
        } else { //acknowledging that horse is slower than opponent
            totalRaces++; //adding 1 to totalRaces
            System.out.println(name+" has lost the race.");
        }
    }
}

//creating ShowHorse subclass
class ShowHorse extends Horse {
    int topSkill;
    int numberOfShowTitles;
    int totalContests;
    int totalPrizeMoney;
    //constructor
    public ShowHorse(String horseName,String horseGender,int year,int month,int day,int topSkill,int numberOfShowTitles,int totalContests,int totalPrizeMoney) {
        super(horseName, horseGender, year, month, day);
        this.topSkill = topSkill;
        this.numberOfShowTitles = numberOfShowTitles;
        this.totalContests = totalContests;
        this.totalPrizeMoney = totalPrizeMoney;
    }
    //printing horse show stats
    public void printShowStats() {
        System.out.println(name+" is a show horse that has "+numberOfShowTitles+" show titles from "+totalContests+" contests, won "+totalPrizeMoney+" dollars in prize money, and a top skill of "+topSkill+".");
    }
    //running horse in a contest
    public void contest(int opponentTopSkill) {
        if (opponentTopSkill < topSkill) { //checking if horse is more skilled than opponent
            numberOfShowTitles++; //adding 1 to numberOfShowTitles
            totalPrizeMoney += 1000; //adding 1,000 to total prizeMoney
            totalContests++; //adding 1 to totalContests
            System.out.println(name+" won the contest!");
        } else if (opponentTopSkill == topSkill) { //checking if horse is the same skill as opponent
            totalPrizeMoney += 500; //adding 500 to total prizeMoney
            totalContests++; //adding 1 to totalContests
            System.out.println("The contest ended in a tie!");
        } else { //acknowledging that horse is less skilled than opponent
            totalContests++; //adding 1 to totalContests
            System.out.println(name+" has lost the contest.");
        }
    }
}
//running above code
class Driver {
    public static void main(String[] args) {

        //creating new horse named "Jet"
        Horse horse1 = new Horse("Jet", "male", 2000, 10, 27);
        //creating new horse named "Minx"
        RaceHorse horse2 = new RaceHorse("Minx", "female", 2015, 6, 19, 18, 23, 56, 18000);
        //creating new horse named "Kai"
        ShowHorse horse3 = new ShowHorse("Kai", "male", 2007, 9, 11, 37, 14, 20, 14000);

        //creating an array of all horses
        Horse[] allHorses = {horse1,horse2,horse3};
        //setting age for all horses
        for (int i = 0; i < allHorses.length; i++) {
            allHorses[i].setAge(2022, 10);
        }
        //running birthday function for all horses
        for (int i = 0; i < allHorses.length; i++) {
            allHorses[i].Birthday(10, 27);
        }
        //print all horse details
        for (int i = 0; i < allHorses.length; i++) {
            allHorses[i].printHorse();
        }

        System.out.println();//adding a space
        //printing horse2's race stats
        horse2.printRaceStats();
        System.out.println(horse2.name+" ran in a few more races.");
        //running horse2 in 3 more races
        horse2.race(50);
        horse2.race(61);
        horse2.race(56);
        //printing horse2's race stats
        horse2.printRaceStats();
        System.out.println();//adding a space

        //printing horse3's show stats
        horse3.printShowStats();
        System.out.println(horse3.name+" entered three more contests.");
        //running horse3 in 3 more contests
        horse3.contest(42);
        horse3.contest(37);
        horse3.contest(32);
        //printing horse3's show stats
        horse3.printShowStats();

        System.out.println();
        System.out.println(horse3.name+"'s owner wants to change his name to Chase.");
        horse3.nameChange("Chase");
        //printing horse3's show stats
        horse3.printShowStats();
    }
}