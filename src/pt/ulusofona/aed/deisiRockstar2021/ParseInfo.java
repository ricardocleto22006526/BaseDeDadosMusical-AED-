package pt.ulusofona.aed.deisiRockstar2021;

public class ParseInfo {
    int numLinhasOk;
    int numLinhasIgnored;

    public ParseInfo() {

    }

    public ParseInfo(int numLinhasOk, int numLinhasIgnored) {
        this.numLinhasOk = numLinhasOk;
        this.numLinhasIgnored = numLinhasIgnored;
    }


    @Override
    public String toString() {
        return "OK:" + " " + numLinhasOk + "," + " " + "Ignored:" + " " + numLinhasIgnored;
    }
}