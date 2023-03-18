package com.busraciftlik.turkcell.game.service;

import java.util.List;

import com.busraciftlik.turkcell.game.database.CampaignDatabase;
import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.ex.CampaignNotFoundException;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;

public class CampaignService implements BaseInterface<Campaign> {

    @Override
    public void add(Campaign campaign) {
        CampaignDatabase.campaignList.add(campaign);
    }

    @Override
    public void update(Campaign campaign) {
        for (Campaign availablecampaign : CampaignDatabase.campaignList) {
            if(availablecampaign.getId() == campaign.getId()){
                availablecampaign.setDiscountPercentage(campaign.getDiscountPercentage());
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i<CampaignDatabase.campaignList.size(); i++){
            if(CampaignDatabase.campaignList.get(i).getId() == id){
                CampaignDatabase.campaignList.remove(i);
            }
        }
    }

    @Override
    public List<Campaign> getAll() {
        return CampaignDatabase.campaignList;
    }

    @Override
    public Campaign getById(int id) {
        for (int i = 0; i<CampaignDatabase.campaignList.size(); i++){
            if(CampaignDatabase.campaignList.get(i).getId() == id){
                return CampaignDatabase.campaignList.get(i);
            }
        }
        throw new CampaignNotFoundException(id);
    }

    @Override
    public Campaign getByName(String name) {
        for (int i = 0; i<CampaignDatabase.campaignList.size(); i++){
            if(CampaignDatabase.campaignList.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                return CampaignDatabase.campaignList.get(i);
            }
        }
        throw new CampaignNotFoundException(name);
    }
    
}
