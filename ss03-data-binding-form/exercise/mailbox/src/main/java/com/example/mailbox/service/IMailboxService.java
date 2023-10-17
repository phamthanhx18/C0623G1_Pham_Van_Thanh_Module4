package com.example.mailbox.service;

import com.example.mailbox.model.Mailbox;

public interface IMailboxService {
    Mailbox getMailbox();
    void updateMailbox(Mailbox mailboxUpdate);
}
