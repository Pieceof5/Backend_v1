package com.moniala.dynamic_table.controller;

import com.moniala.dynamic_table.model.Card;
import com.moniala.dynamic_table.model.Column;
import com.moniala.dynamic_table.model.Row;
import com.moniala.dynamic_table.service.CardService;
import com.moniala.dynamic_table.service.ColumnService;
import com.moniala.dynamic_table.service.RowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui/cards")
public class CardViewController {

    private final CardService cardService;
    private final ColumnService columnService;
    private final RowService rowService;

    public CardViewController(CardService cardService, ColumnService columnService, RowService rowService) {
        this.cardService = cardService;
        this.columnService = columnService;
        this.rowService = rowService;
    }

    @GetMapping
    public String listCards(Model model) {
        model.addAttribute("cards", cardService.getAllCards());
        model.addAttribute("card", new Card());
        model.addAttribute("column", new Column());
        model.addAttribute("row", new Row());
        return "cards";
    }

    @PostMapping("/add")
    public String addCard(@ModelAttribute Card card) {
        cardService.saveCard(card);
        return "redirect:/ui/cards";
    }
    
    @PostMapping("/{cardId}/delete")
    public String deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return "redirect:/ui/cards"; // Päivittää näkymän heti
    }

    @PostMapping("/{cardId}/columns/add")
    public String addColumn(@PathVariable Long cardId, @ModelAttribute Column column) {
        Card card = cardService.getCardById(cardId);
        column.setCard(card);
        columnService.saveColumn(column);
        return "redirect:/ui/cards";
    }

    @PostMapping("/{cardId}/columns/{columnId}/delete")
    public String deleteColumn(@PathVariable Long cardId, @PathVariable Long columnId) {
        columnService.deleteColumn(columnId);
        return "redirect:/ui/cards";
    } 

    @PostMapping("/{cardId}/rows/add")
    public String addRow(@PathVariable Long cardId, @ModelAttribute Row row) {
        Card card = cardService.getCardById(cardId);
        row.setCard(card);
        rowService.saveRow(row);
        return "redirect:/ui/cards";
    }

    @PostMapping("/{cardId}/rows/{rowId}/delete")
    public String deleteRow(@PathVariable Long cardId, @PathVariable Long rowId) {
        rowService.deleteRow(rowId);
        return "redirect:/ui/cards";
    }
}