package org.sb.core.command.api;

import java.util.Iterator;
import java.util.Map;

/**
 * <p>A {@link Catalog} is a collection of named {@link Command}s (or
 * {@link Chain}s) that can be used to retrieve the set of commands that
 * should be performed based on a symbolic identifier.  Use of catalogs
 * is optional, but convenient when there are multiple possible chains
 * that can be selected and executed based on environmental conditions.</p>
 *
 * @param <K> the type of keys maintained by the context associated with this command
 * @param <V> the type of mapped values
 * @param <C> Type of the context associated with this command
 *
 * @version $Id$
 */
public interface Catalog<K, V, C extends Map<K, V>> {

    /**
     * <p>A default context attribute for storing a default {@link Catalog},
     * provided as a convenience only.</p>
     */
    String CATALOG_KEY = "org.apache.commons.chain2.CATALOG";

    /**
     * <p>Add a new name and associated {@link Command} or {@link Chain}
     * to the set of named commands known to this {@link Catalog},
     * replacing any previous command for that name.
     *
     * @param <CMD> the {@link Command} type to be added in the {@link Catalog}
     * @param name Name of the new command
     * @param command {@link Command} or {@link Chain} to be returned
     *  for later lookups on this name
     */
    <CMD extends Command<K, V, C>> void addCommand(String name, CMD command);

    /**
     * <p>Return the {@link Command} or {@link Chain} associated with the
     * specified name, if any; otherwise, return <code>null</code>.</p>
     *
     * @param <CMD> the expected {@link Command} type to be returned
     * @param name Name for which a {@link Command} or {@link Chain}
     *  should be retrieved
     * @return The Command associated with the specified name.
     */
    <CMD extends Command<K, V, C>> CMD getCommand(String name);

    /**
     * <p>Return an <code>Iterator</code> over the set of named commands
     * known to this {@link Catalog}.  If there are no known commands,
     * an empty Iterator is returned.</p>
     * @return An iterator of the names in this Catalog.
     */
    Iterator<String> getNames();

}
