package jp.co.mixi.androidtraining.sns.repository

import jp.co.mixi.androidtraining.sns.data.entity.Post
import jp.co.mixi.androidtraining.sns.data.repository.TimelineRepository
import kotlinx.coroutines.delay

class FakeTimelineRepository(private val timeline: List<Post>) : TimelineRepository {
    override suspend fun getTimeline(): List<Post> {
        delay(2000)
        return timeline
    }
}
