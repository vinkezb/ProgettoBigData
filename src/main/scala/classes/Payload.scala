package classes

case class Payload (
                   action: String,
                   before: String,
                   comment: Comment,
                   commit: Commit,
                   description: String,
                   distinct_size: Option[Long],
                   forkee: Forkee,
                   head: String,
                   issue: Issue,
                   master_branch: String,
                   member: Member,
                   number: Option[Long],
                   pages: Pages,
                   pull_request: PullRequest,
                   push_id: Option[Long],
                   pusher_type: String,
                   ref: String,
                   ref_type: String,
                   release: Release,
                   size: Option[Long]
              )
