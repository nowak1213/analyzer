package com.merapar.nowakowski.bartlomiej.analyzer.model;

import com.merapar.nowakowski.bartlomiej.analyzer.handler.LocalDateTimeAdapter;

import static com.merapar.nowakowski.bartlomiej.analyzer.constants.AnalyzerConstants.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name=ROW)
@XmlAccessorType(XmlAccessType.FIELD)
public class Row {

    @XmlAttribute(name = ID)
    private Long id;

    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    private LocalDateTime creationDate;

    @XmlAttribute(name = ACCEPTED_ANSWER_ID)
    private Long acceptedAnswerId;

    @XmlAttribute(name = SCORE)
    private Integer score;

    public Row() {
    }

    public Row(Long id, LocalDateTime creationDate, Long acceptedAnswerId, Integer score) {
        this.id = id;
        this.creationDate = creationDate;
        this.acceptedAnswerId = acceptedAnswerId;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Long acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", acceptedAnswerId=" + acceptedAnswerId +
                ", score=" + score +
                '}';
    }
}
