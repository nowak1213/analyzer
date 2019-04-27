package com.merapar.nowakowski.bartlomiej.analyzer.controller;

import com.merapar.nowakowski.bartlomiej.analyzer.model.AnalyzeResponse;
import com.merapar.nowakowski.bartlomiej.analyzer.service.AnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/analyze")
@RestController
public class AnalyzerController {

    @Autowired
    AnalyzerService analyzerService;

    @PostMapping
    @ResponseBody
    AnalyzeResponse analyzeXML(@RequestParam String url) {
        return analyzerService.analyzeXML(url);
    }

}
