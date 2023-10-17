package com.example.mailbox.repository;

import com.example.mailbox.model.Mailbox;
import org.springframework.stereotype.Repository;

@Repository
public class MailboxRepo implements IMailboxRepo{
    private static Mailbox mailbox;
    static {
        mailbox = new Mailbox();
    }
    @Override
    public Mailbox getMailbox() {
        return mailbox;
    }

    @Override
    public void updateMailbox(Mailbox mailboxUpdate) {
        mailbox.setLanguage(mailboxUpdate.getLanguage());
        mailbox.setPageSize(mailboxUpdate.getPageSize());
        mailbox.setSpamsFilter(mailboxUpdate.getSpamsFilter());
        mailbox.setSignature(mailboxUpdate.getSignature());
    }
}
