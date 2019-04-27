package com.merapar.nowakowski.bartlomiej.analyzer.service;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;
import com.merapar.nowakowski.bartlomiej.analyzer.service.postsInterfaces.CountAvgScorePosts;
import com.merapar.nowakowski.bartlomiej.analyzer.service.postsInterfaces.CountTotalAcceptedPosts;
import com.merapar.nowakowski.bartlomiej.analyzer.service.postsInterfaces.FirstAndLastDatePosts;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DetailsPostsProvider implements CountAvgScorePosts, CountTotalAcceptedPosts, FirstAndLastDatePosts {

    @Override
    public Integer countAvgScorePosts(List<Row> rows) {
        long sumScore = rows.stream()
                .mapToLong(Row::getScore)
                .sum();
        return Math.toIntExact(sumScore / rows.size());
    }

    @Override
    public LocalDateTime firstDatePost(List<Row> rows) {
        return rows.stream()
                .map(Row::getCreationDate)
                .min(LocalDateTime::compareTo)
                .get();
    }

    @Override
    public LocalDateTime lastDatePost(List<Row> rows) {
        return rows.stream()
                .map(Row::getCreationDate)
                .max(LocalDateTime::compareTo)
                .get();
    }

    @Override
    public Long countTotalAcceptedPost(List<Row> rows) {
        return rows.stream()
                .filter(row -> row.getAcceptedAnswerId() != null)
                .count();
    }
}
