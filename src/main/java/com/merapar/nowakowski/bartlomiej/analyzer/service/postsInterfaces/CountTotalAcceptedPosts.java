package com.merapar.nowakowski.bartlomiej.analyzer.service.postsInterfaces;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;

import java.util.List;

public interface CountTotalAcceptedPosts {
    Long countTotalAcceptedPost(List<Row> rows);
}
