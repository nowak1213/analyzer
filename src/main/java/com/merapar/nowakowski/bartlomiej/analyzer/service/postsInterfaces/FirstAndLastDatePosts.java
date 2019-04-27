package com.merapar.nowakowski.bartlomiej.analyzer.service.postsInterfaces;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;

import java.time.LocalDateTime;
import java.util.List;

public interface FirstAndLastDatePosts {
    LocalDateTime firstDatePost(List<Row> rows);
    LocalDateTime lastDatePost(List<Row> rows);
}
