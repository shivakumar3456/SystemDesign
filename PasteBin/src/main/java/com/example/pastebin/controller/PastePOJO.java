package com.example.pastebin.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PastePOJO {
    private @NotNull String content = "";
    private @NotNull String title = "";
    private int permission;
    private int userId;
    private @Nullable String pasteURL;

    @NotNull
    public String getContent() {
        return content;
    }

    public void setContent(@NotNull String content) {
        this.content = content;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPasteURL(@NotNull String pasteURL) {
        this.pasteURL = pasteURL;
    }

    @Nullable
    public String getPasteURL() {
        return pasteURL;
    }

    @Override
    public @NotNull String toString() {
        return "Paste URL : " + pasteURL + " \n content : " + content + " title : " + title;
    }
}
