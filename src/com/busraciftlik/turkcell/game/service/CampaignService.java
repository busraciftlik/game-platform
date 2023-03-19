package com.busraciftlik.turkcell.game.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.busraciftlik.turkcell.game.database.OnMemoryDatabase;
import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.ex.CampaignNotFoundException;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class CampaignService implements BaseInterface<Campaign> {

    @Override
    public void add(Campaign campaign) {
        OnMemoryDatabase.CAMPAIGNS.put(campaign.getId(), campaign);
    }

    @Override
    public void update(Campaign campaign) {
        if (OnMemoryDatabase.CAMPAIGNS.containsKey(campaign.getId())) {
            OnMemoryDatabase.CAMPAIGNS.put(campaign.getId(), campaign);
        } else {
            throw new CampaignNotFoundException(campaign.getId());
        }
    }

    @Override
    public void delete(int id) {
        if (OnMemoryDatabase.CAMPAIGNS.containsKey(id)) {
            OnMemoryDatabase.CAMPAIGNS.remove(id);
        }
        throw new CampaignNotFoundException(id);
    }

    @Override
    public List<Campaign> getAll() {
        return new ArrayList<>(OnMemoryDatabase.CAMPAIGNS.values());
    }

    @Override
    public Campaign getById(int id) {
        return OnMemoryDatabase.CAMPAIGNS.get(id);
    }

    @Override
    public Campaign getByName(String name) {
        Collection<Campaign> campaigns = OnMemoryDatabase.CAMPAIGNS.values();
        for (Campaign campaign : campaigns) {
            if (campaign.getName().equalsIgnoreCase(name)) {
                return campaign;
            }
        }
        throw new CampaignNotFoundException(name);
    }
}
