package classes

case class Wrapper(
                    actor: Actor,
                    created_at: String,
                    id: String,
                    org: Org,
                    public: Boolean,
                    repo: Repo,
                    `type`: String
                  )
