package nl.dhoang.page;

import java.net.URI;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public record ErrorPage(URI url, Exception ex) implements Page {

    public ErrorPage {
        requireNonNull(url);
        requireNonNull(ex);
    }

    @Override
    public boolean equals(Object other) {
            return other == this
                        || other instanceof GitHubIssuePage page
                        && this.url.equals(page.url());
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
