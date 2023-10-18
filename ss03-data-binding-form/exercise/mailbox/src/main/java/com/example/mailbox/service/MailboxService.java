package com.example.mailbox.service;

import com.example.mailbox.model.Mailbox;
import com.example.mailbox.repository.IMailboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailboxService{
    @Autowired
    private IMailboxRepo mailboxRepo;
    @Override
    public Mailbox getMailbox() {
        return mailboxRepo.getMailbox();
    }

    @Override
    public void updateMailbox(Mailbox mailboxUpdate) {
        mailboxRepo.updateMailbox(mailboxUpdate);
    }
}
