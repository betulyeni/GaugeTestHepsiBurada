package com.testinium;

import com.csvreader.CsvWriter;
import com.testinium.Base.BaseTest;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import sun.security.mscapi.CPublicKey;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteCvsFile  extends BaseTest {
    private static StepImplementation driver;
     @Step("urun adı <urunAdi> urun tutar <urunTutar>")
    public  void main(String urunAdi,String urunTutar) throws IOException {
        FileWriter writecsv = new FileWriter ("filename.csv");
        Writer append = writecsv.append("urunAdi,urunTutar");
                writecsv.append('\n');

    }
}





