def call(Map gitParams) {
    git branch: gitParams.branch, url: gitParams.url
}