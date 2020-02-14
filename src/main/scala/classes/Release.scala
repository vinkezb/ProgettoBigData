package classes

case class Release(
                    assets: Array[Assets],
                    assets_url: String,
                    author: AuthorRelease,
                    body: String,
                    created_at: String,
                    draft: Boolean,
                    html_url: String,
                    id: Long,
                    name: String,
                    prerelease: Boolean,
                    published_at: String,
                    tag_name: String,
                    tarball_url: String,
                    target_commitish: String,
                    upload_url: String,
                    url: String,
                    zipball_url: String
                  )
