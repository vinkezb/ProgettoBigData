package classes

case class Milestone(
                    closed_at: String,
                    closed_issues: Long,
                    created_at: String,
                    creator: Creator,
                    description: String,
                    due_on: String,
                    html_url: String,
                    id: Long,
                    labels_url: String,
                    number: Long,
                    open_issues: Long,
                    state: String,
                    title: String,
                    updated_at: String,
                    url: String
                    )
