case class Payload (
                   action: String,
                   before: String,
                   comment: Comment,
                   author_association: String,
                   body: String,
                   commit_id: String,
                   created_at: String,
                   diff_hunk: String,
                   html_url: String,
                   id: Long,
                   in_reply_to_id: Long,
                   issue_url: String,
                   line: Long,
                   original_commit_id: String,
                   original_position: Long,
                   path: String,
                   position: Long,
                   pull_request_review_id: Long,
                   pull_request_url: String,
                   updated_at: String,
                   url: String,
                   user: User,
                   commit: Commit,
                   description: String,
                   distinct_size: Long,

                   head: String,
                   issue: Issue
              )
