package classes

import java.io.Serializable

class RepoHead (
                      archive_url: String,
                      archived: Boolean,
                      assignees_url: String,
                      blobs_url: String,
                      branches_url: String,
                      clone_url: String,
                      collaborators_url: String,
                      comments_url: String,
                      commits_url: String,
                      compare_url: String,
                      contents_url: String,
                      contributors_url: String,
                      created_at: String,
                      default_branch: String,
                      deployments_url: String,
                      description: String,
                      downloads_url: String,
                      events_url: String,
                      fork: Boolean,
                      forks: Long,
                      forks_count: Long,
                      forks_url: String,
                      full_name: String,
                      git_commits_url: String,
                      git_refs_url: String,
                      git_tags_url: String,
                      git_url: String,
                      has_downloads: Boolean,
                      has_issues: Boolean,
                      has_pages: Boolean,
                      has_projects: Boolean,
                      has_wiki: Boolean,
                      homepage: String,
                      hooks_url: String,
                      html_url: String,
                      id: Long,
                      issue_comment_url: String,
                      issue_events_url: String,
                      issues_url: String,
                      keys_url: String,
                      labels_url: String,
                      language: String,
                      languages_url: String,
                      license: License,
                      merges_url: String,
                      milestones_url: String,
                      mirror_url: String,
                      name: String,
                      notifications_url: String,
                      open_issues: Long,
                      open_issues_count: Long,
                      owner: Owner,
//                      `private`: Boolean,
                      pulls_url: String,
                      pushed_at: String,
                      releases_url: String,
                      size: Long,
                      ssh_url: String,
                      stargazers_count: Long,
                      stargazers_url: String,
                      statuses_url: String,
                      subscribers_url: String,
                      subscription_url: String,
                      svn_url: String,
                      tags_url: String,
                      teams_url: String,
                      trees_url: String,
                      updated_at: String,
                      url: String,
                      watchers: Long,
                      watchers_count: Long
                    )

  extends Product with Serializable {
  def canEqual(that: Any) = that.isInstanceOf[RepoHead_]

  def productArity = 70

  def productElement(idx: Int) = idx match {
    case 0 => archive_url
    case 1 => archived
    case 2 => assignees_url
    case 3 => blobs_url
    case 4 => branches_url
    case 5 => clone_url
    case 6 => collaborators_url
    case 7 => comments_url
    case 8 => commits_url
    case 9 => compare_url
    case 10 => contents_url
    case 11 => contributors_url
    case 12 => created_at
    case 13 => default_branch
    case 14 => deployments_url
    case 15 => description
    case 16 => downloads_url
    case 17 => events_url
    case 18 => fork
    case 19 => forks
    case 20 => forks_count
    case 21 => forks_url
    case 22 => full_name
    case 23 => git_commits_url
    case 24 => git_refs_url
    case 25 => git_tags_url
    case 26 => git_url
    case 27 => has_downloads
    case 28 => has_issues
    case 29 => has_pages
    case 30 => has_projects
    case 31 => has_wiki
    case 32 => homepage
    case 33 => hooks_url
    case 34 => html_url
    case 35 => id
    case 36 => issue_comment_url
    case 37 => issue_events_url
    case 38 => issues_url
    case 39 => keys_url
    case 40 => labels_url
    case 41 => language
    case 42 => languages_url
    case 43 => license
    case 44 => merges_url
    case 45 => milestones_url
    case 46 => mirror_url
    case 47 => name
    case 48 => notifications_url
    case 49 => open_issues
    case 50 => open_issues_count
    case 51 => owner
//    case 52 => `private`
    case 53 => pulls_url
    case 54 => pushed_at
    case 55 => releases_url
    case 56 => size
    case 57 => ssh_url
    case 58 => stargazers_count
    case 59 => stargazers_url
    case 60 => statuses_url
    case 61 => subscribers_url
    case 62 => subscription_url
    case 63 => svn_url
    case 64 => tags_url
    case 65 => teams_url
    case 66 => trees_url
    case 67 => updated_at
    case 68 => url
    case 69 => watchers
    case 70 => watchers_count
  }
}