package com.merapar.nowakowski.bartlomiej.analyzer;

import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;
import com.merapar.nowakowski.bartlomiej.analyzer.service.DetailsPostsProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class DetailsPostsProviderTest {

    DetailsPostsProvider detailsPostsProvider;
    List<Row> rows;

    @Before
    public void setUp() {
        detailsPostsProvider = new DetailsPostsProvider();
        rows = new ArrayList<>();
        rows.add(new Row(1L, LocalDateTime.parse("2015-07-14T18:39:27.757"), 2L, 2));
        rows.add(new Row(2L, LocalDateTime.parse("2016-09-14T18:11:27.757"), null, -9));
        rows.add(new Row(3L, LocalDateTime.parse("2016-09-16T18:11:27.757"), 15L, 3));
    }

    @After
    public void tearDown() {
        rows = null;
    }

    @Test
    public void shouldCountOnly2AcceptedPosts() {
        assertThat(2L).isEqualTo(detailsPostsProvider.countTotalAcceptedPost(rows));
    }

    @Test
    public void shouldRoundToMinusAvgScorePosts() {
        assertThat(-1).isEqualTo(detailsPostsProvider.countAvgScorePosts(rows));
    }

    @Test
    public void shouldRoundToLowerAvgScorePosts() {
        rows.add(new Row(4L, LocalDateTime.parse("2016-09-16T18:11:27.757"), 15L, 11));
        assertThat(1).isEqualTo(detailsPostsProvider.countAvgScorePosts(rows));
    }

    @Test
    public void shouldReturnLastPostNewerBySeconds() {
        rows.add(new Row(3L, LocalDateTime.parse("2016-09-16T18:11:57.757"), 15L, 3));
        assertThat(LocalDateTime.parse("2016-09-16T18:11:57.757")).isEqualTo(detailsPostsProvider.lastDatePost(rows));
    }

    @Test
    public void shouldReturnLastPostNewerByDay() {
        rows.add(new Row(3L, LocalDateTime.parse("2016-09-17T18:11:27.757"), 15L, 3));
        assertThat(LocalDateTime.parse("2016-09-17T18:11:27.757")).isEqualTo(detailsPostsProvider.lastDatePost(rows));
    }

    @Test
    public void shouldReturnFirstPost() {
        assertThat(LocalDateTime.parse("2015-07-14T18:39:27.757")).isEqualTo(detailsPostsProvider.firstDatePost(rows));
    }

}
