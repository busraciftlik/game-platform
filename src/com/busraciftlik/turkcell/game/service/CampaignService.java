package com.busraciftlik.turkcell.game.service;

import com.busraciftlik.turkcell.game.database.OnMemoryDatabase;
import com.busraciftlik.turkcell.game.entity.Campaign;
import com.busraciftlik.turkcell.game.ex.CampaignNotFoundException;
import com.busraciftlik.turkcell.game.service.api.BaseInterface;
import com.busraciftlik.turkcell.game.util.DatabaseSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CampaignService implements BaseInterface<Campaign> {

    public static final String INSERT_INTO_CAMPAIGN = "INSERT INTO campaign VALUES (?,?)";

    @Override
    public void add(Campaign campaign) {
        try (Connection connection = DatabaseSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_CAMPAIGN)) {
            statement.setString(1, campaign.getName());
            statement.setDouble(2, campaign.getDiscountPercentage());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //OnMemoryDatabase.CAMPAIGNS.put(campaign.getId(), campaign);
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
