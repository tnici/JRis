package com.gmail.gcolaianni5.jris.engine;

import com.gmail.gcolaianni5.jris.bean.Record;
import com.gmail.gcolaianni5.jris.exception.JRisException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParseTest {

    @Test
    public void parseSimpleTest() throws IOException, JRisException {
        String ris = "TY  - JOUR\n" +
                "TI  - First record of a freshwater jellyfish,craspedacusta sowerbiilankester, 1880 (limnomedusae, olindiidae) from reservoirs in Korea\n" +
                "ER  - ";
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ris.getBytes());
        final List<Record> records = JRis.parse(byteArrayInputStream);
        assertEquals("First record of a freshwater jellyfish,craspedacusta sowerbiilankester, 1880 (limnomedusae, olindiidae) from reservoirs in Korea", records.get(0).getTitle());
    }

    @Test
    public void parseWithLinebreakTest() throws IOException, JRisException {
        String ris = "TY  - JOUR\n" +
                "TI  - First record of a freshwater jellyfish,craspedacusta sowerbiilankester,\n1880 (limnomedusae, olindiidae) from reservoirs in Korea\n" +
                "ER  - ";
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ris.getBytes());
        final List<Record> records = JRis.parse(byteArrayInputStream);
        assertEquals("First record of a freshwater jellyfish,craspedacusta sowerbiilankester, 1880 (limnomedusae, olindiidae) from reservoirs in Korea", records.get(0).getTitle());
    }

}
