

case class Issue(
                assignee: Assignee,
                assignees: Array[Assignees],
                author_association: String,
                body: String,
                closed_at: String,
                comments: Long,
                comments_url: String,
                created_at: String,
                events_url: String,
                html_url: String,
                id: Long,
                labels: Array[Labels],
                labels_url: String,
                locked: Boolean,
                milestone: Milestone,
                number: Long,
                pull_request: Pull_request,
                repository_url: String,
                state: String,
                title: String,
                updated_at: String,
                url: String,
                user: User
                )
