package Bot.scraping;

public class Message {
    //text data
    private String test = "";
    private String pcr = "";
    private String deathGuys = "";
    private String vaccineNumber = "";
    private String nameDay = "";

    public Message(String test, String pcr, String deathGuys, String vaccineNumber, String nameDay) {
        this.test = test;
        this.pcr = pcr;
        this.deathGuys = deathGuys;
        this.vaccineNumber = vaccineNumber;
        this.nameDay = nameDay;
    }

    public String getTest() {
        return test;
    }

    public String getPcr() {
        return pcr;
    }

    public String getDeathGuys() {
        return deathGuys;
    }

    public String getVaccineNumber() {
        return vaccineNumber;
    }

    public String getNameDay() {
        return nameDay;
    }
}
