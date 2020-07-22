package com.lenis0012.bukkit.marriage2;

import java.util.UUID;

public interface MPlayer {

    /**
     * Get unique User Id of the player.
     *
     * @return Player's unique user id.
     */
    UUID getUniqueId();

    /**
     * Request marriage with this player by another.
     *
     * @param from Player who requested the marriage.
     */
    void requestMarriage(UUID from);

    /**
     * Check if marriage with this player is requested by another.
     *
     * @param from Marriage requester.
     * @return Whether or not marriage is requested by the player.
     */
    boolean isMarriageRequested(UUID from);

    /**
     * Get current marriage of the player.
     *
     * @return Player's marriage, NULL if not married.
     */
    //     * @deprecated Use {@link #getFirstMarriage()} or {@link #getMarriage(UUID)} or {@link #getMarriages()}
//    @Deprecated
    MData getMarriage();

//    MData getFirstMarriage();

//    MData getMarriage(UUID withPlayer);

//    MData getMarriages();

    /**
     * Get the last name the player logged on with.
     *
     * @return Last name, can be null
     */
    String getLastName();

    /**
     * Check if the player is married.
     *
     * @return True if married, false otherwise.
     */
    boolean isMarried();

    /**
     * Check if the player is in marry-chat mode.
     *
     * @return True if in chat-mode, false otherwise.
     */
    boolean isInChat();

    /**
     * Whether or not the player is a priest.
     *
     * @return True if player ius priest, false otherwise
     */
    boolean isPriest();

    /**
     * Set the last name the player logged on with.
     *
     * @param name of player
     */
    void setLastName(String name);

    /**
     * Set whether or not this player is a priest.
     *
     * @param priest True if player is priest, false otherwise
     */
    void setPriest(boolean priest);

    /**
     * Set if the player is in marry chat-mode.
     *
     * @param inChat Whether or not the player is in marry chat-mode.
     */
    void setInChat(boolean inChat);

    /**
     * Get the current player's partner
     *
     * @return Current partner of the player
     */
    MPlayer getPartner();

    /**
     * Divorce with the current player's partner
     */
    void divorce();

    /**
     * Get timestamp of last time player logged in.
     *
     * @return Last login timestamp.
     */
    long getLastLogin();

    /**
     * Get timestamp of last time player logged out.
     *
     * @return Last logout timestamp.
     */
    long getLastLogout();

    /**
     * Said whether or not player is spying on marriage private chat.
     *
     * @param enabled True if enables, false otherwise
     */
    void setChatSpy(boolean enabled);

    /**
     * Get whether or not player is spying on marriage private chat.
     *
     * @return True if enabled, false otherwise
     */
    boolean isChatSpy();
}