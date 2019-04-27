package com.merapar.nowakowski.bartlomiej.analyzer.service.impl;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;
import com.merapar.nowakowski.bartlomiej.analyzer.model.AnalyzeResponse;
import com.merapar.nowakowski.bartlomiej.analyzer.handler.AnalyzerHandler;
import com.merapar.nowakowski.bartlomiej.analyzer.service.AnalyzerService;
import com.merapar.nowakowski.bartlomiej.analyzer.service.DetailsPostsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalyzerServiceImpl implements AnalyzerService {

    @Autowired
    DetailsPostsProvider detailsPostsProvider;

    @Override
    public AnalyzeResponse analyzeXML(String url) {

        AnalyzerHandler handler = new AnalyzerHandler();

        try {
            XMLReader myReader = XMLReaderFactory.createXMLReader();
            myReader.setContentHandler(handler);
            myReader.parse(new InputSource(new URL(url).openStream()));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        return provideAnalyzeResponse(handler.getRowList());
    }

    private AnalyzeResponse provideAnalyzeResponse(List<Row> rows) {
        AnalyzeResponse response = new AnalyzeResponse();
        response.setAnalyzeDate(LocalDateTime.now());
        response.getDetails().setFirstPost(detailsPostsProvider.firstDatePost(rows));
        response.getDetails().setLastPost(detailsPostsProvider.lastDatePost(rows));
        response.getDetails().setTotalPosts((long) rows.size());
        response.getDetails().setAvgScore(detailsPostsProvider.countAvgScorePosts(rows));
        response.getDetails().setTotalAcceptedPosts(detailsPostsProvider.countTotalAcceptedPost(rows));
        return response;
    }


}
