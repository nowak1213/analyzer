package com.merapar.nowakowski.bartlomiej.analyzer.model;

import java.time.LocalDateTime;

public class Details {
    private LocalDateTime firstPost;
    private LocalDateTime lastPost;
    private Long totalPosts;
    private Long totalAcceptedPosts;
    private Integer avgScore;

    public LocalDateTime getFirstPost() {
        return firstPost;
    }

    public void setFirstPost(LocalDateTime firstPost) {
        this.firstPost = firstPost;
    }

    public LocalDateTime getLastPost() {
        return lastPost;
    }

    public void setLastPost(LocalDateTime lastPost) {
        this.lastPost = lastPost;
    }

    public Long getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(Long totalPosts) {
        this.totalPosts = totalPosts;
    }

    public Long getTotalAcceptedPosts() {
        return totalAcceptedPosts;
    }

    public void setTotalAcceptedPosts(Long totalAcceptedPosts) {
        this.totalAcceptedPosts = totalAcceptedPosts;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "Details{" +
                "firstPost=" + firstPost +
                ", lastPost=" + lastPost +
                ", totalPosts=" + totalPosts +
                ", totalAcceptedPosts=" + totalAcceptedPosts +
                ", avgScore=" + avgScore +
                '}';
    }
}
