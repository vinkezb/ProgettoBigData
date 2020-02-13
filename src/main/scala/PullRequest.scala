import java.io.Serializable
import java.sql.Array

case class PullRequest(
                      _links: LinksPullRequest,
                      addictions: Long,
                      assignee: Assignee,
                      assignees: Array[Assignees],
                      authorAssociation: String,
                      base: Base,
                      body: String,
                      changed_files: Long,
                      closed_at: String,
                      comments: Long,
                      comments_url: String,
                      commits: Long,
                      commits_url: String,
                      created_at: String,
                      deletions: Long,
                      diff_url: String,
                      head: Head,
                      html_url: String,
                      id: Long,
                      issue_url: String,
                      labels: Array[Labels],
                      locked:Boolean,
                      maintainer_can_modify: Boolean,
                      merge_commit_sha: String,
                      mergeable: Boolean,
                      mergeable_state: String,
                      merged: Boolean,
                      merged_at: String,
                      merged_by: Merged_by,
                      milestone: Milestone,
                      numeber: Long,
                      patch_url: String,
                      rebaseable: Boolean,
                      requested_reviewers: Array[Requested_reviewers],
                      requested_teams: Array[Requested_teams],
                      review_comment_url: String,
                      review_comments: Long,
                      review_comments_url: String,
                      state: String,
                      statuses_url: String,
                      title: String,
                      updated_at: String,
                      url: String,
                      user: User
)

extends Product with Serializable{
  def canEqual(that: Any) = that.isInstanceOf[PullRequest]

  def productArity = 44

  def productElement(idx: Int) = idx match{
    case 0 => _links
    case 1 => addictions
    case 2 => assignee
    case 3 => assignees
    case 4 => authorAssociation
    case 5 => base
    case 6 => body
    case 7 => changed_files
    case 8 => closed_at
    case 9 => comments
    case 10 => comments_url
    case 11 => commits
    case 12 => comments_url
    case 13 => created_at
    case 14 => deletions
    case 15 => diff_url
    case 16 => head
    case 17 => html_url
    case 18 => id
    case 19 => issue_url
    case 20 => labels
    case 21 => locked
    case 22 => maintainer_can_modify
    case 23 => merge_commit_sha
    case 24 => mergeable
    case 25 => mergeable_state
    case 26 => merged
    case 27 => merged_at
    case 28 => merged_by
    case 29 => milestone
    case 30 => numeber
    case 31 => patch_url
    case 32 => rebaseable
    case 33 => requested_reviewers
    case 34 => requested_teams
    case 35 => review_comment_url
    case 36 => review_comments
    case 37 => review_comments_url
    case 38 => state
    case 39 => statuses_url
    case 40 => title
    case 41 => updated_at
    case 42 => url
    case 43 => user
  }
}



































