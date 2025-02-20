package nl.dhoang.page;

import java.net.URI;
import java.util.Objects;

public sealed interface Page permits ErrorPage, SuccessfulPage {

    URI url();

    boolean equals(Objects other);
}
