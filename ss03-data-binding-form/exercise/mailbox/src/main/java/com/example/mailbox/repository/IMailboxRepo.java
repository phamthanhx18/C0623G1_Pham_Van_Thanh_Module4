package com.example.mailbox.repository;

import com.example.mailbox.model.Mailbox;

public interface IMailboxRepo {
    Mailbox getMailbox();
    void updateMailbox(Mailbox mailboxUpdate);
}
