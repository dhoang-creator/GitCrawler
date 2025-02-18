package nl.dhoang.page;

// how do you reason the tree for the interfaces and the classes?
public sealed interface SuccessfulPage extends Page permits ExternalPage, GithubPage {

    String content();
}
