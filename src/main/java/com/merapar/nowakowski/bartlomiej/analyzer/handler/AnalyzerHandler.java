package com.merapar.nowakowski.bartlomiej.analyzer.handler;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.merapar.nowakowski.bartlomiej.analyzer.constants.AnalyzerConstants.*;

public class AnalyzerHandler extends DefaultHandler {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private List<Row> rowList = null;
    private Row row = null;
    private StringBuilder data = null;

    public List<Row> getRowList() {
        return rowList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase(ROW)) {
            String id = attributes.getValue(ID);
            String creationDate = attributes.getValue(CREATION_DATE);
            String acceptedAnswerId = attributes.getValue(ACCEPTED_ANSWER_ID);
            String score = attributes.getValue(SCORE);

            row = new Row();
            row.setId(Long.parseLong(id));
            row.setCreationDate((creationDate == null) ? null : LocalDateTime.parse(creationDate, FORMATTER));
            row.setAcceptedAnswerId((acceptedAnswerId == null) ? null : Long.parseLong(acceptedAnswerId));
            row.setScore((score == null) ? null : Integer.parseInt(score));

            if (rowList == null) {
                rowList = new ArrayList<>();
            }
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase(ROW)) {
            rowList.add(row);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(new String(ch, start, length));
    }
}
