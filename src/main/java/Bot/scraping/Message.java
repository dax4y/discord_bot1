package Bot.scraping;

public class Message {
    //text data
    private String test = "";
    private String pcr = "";
    private String deathGuys = "";
    private String nameDay = "";
    private String vaccineFirst;
    private String vaccineSecond;

    public Message(String test, String pcr, String deathGuys, String nameDay, String vaccineFirst, String vaccineSecond) {
        this.test = test;
        this.pcr = pcr;
        this.deathGuys = deathGuys;
        this.nameDay = nameDay;
        this.vaccineFirst = vaccineFirst;
        this.vaccineSecond = vaccineSecond;
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

    public String getVaccineFirst() {
        return vaccineFirst;
    }

    public String getVaccineSecond() {
        return vaccineSecond;
    }

    public String getNameDay() {
        return nameDay;
    }
}
