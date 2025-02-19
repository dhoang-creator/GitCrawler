package nl.dhoang.page;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public sealed interface GithubPage extends SuccessfulPage permits GitHubIssuePage, GitHubPrPage {

    Set<Page> links();

    default Stream<Page> subtree() {
        var subtree = new ArrayList<Page>(Set.of(this));
        var upcomingPages = new LinkedHashSet<>(this.links());

        while (!upcomingPages.isEmpty()) {
            var nextPage = upcomingPages.removeFirst();
            if (!subtree.contains(nextPage) && nextPage instanceof GithubPage nextGhPage)
                new LinkedHashSet<>(nextGhPage.links())
                        .reversed()
                        .forEach(upcomingPages::addFirst);

            subtree.add(nextPage);
        }

        // how do you know at this point this is where the subtree is being returned
        return subtree.stream();
    }
}
