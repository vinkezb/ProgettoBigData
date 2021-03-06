package classes

case class Comment(
                  _links: Links,
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
                  position: String,
                  pull_request_review_id: Long,
                  pull_request_url: String,
                  updated_at: String,
                  url: String,
                  user: User
                  )
