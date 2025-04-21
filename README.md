sdui json
```json
{
  "type": "scrollView",
  "value": {
    "scrollDirection": "vertical",
    "marginLeft": 12,
    "marginRight": 12,
    "child": {
      "type": "layout",
      "value": {
        "align": "vertical",
        "items": [
          {
            "type": "text",
            "value": {
              "text": "100$",
              "marginTop": 80,
              "fontSize": 48,
              "textAlignment": "center"
            }
          },
          {
            "type": "text",
            "value": {
              "text": "Ваши монеты",
              "fontSize": 24,
              "marginTop": 12,
              "marginBottom": 12
            }
          },
          {
            "type": "searchField",
            "value": {
              "hint": "Searching...",
              "filterField": "name",
              "child": {
                "type": "layout",
                "value": {
                  "align": "vertical",
                  "items": [
                    {
                      "type": "coin",
                      "value": {
                        "id": 1,
                        "name": "BTC",
                        "layoutWidth": "match_parent",
                        "layoutHeight": "wrap_content",
                        "marginBottom": 24,
                        "price": {
                          "value": 100.3,
                          "currency": "usd"
                        },
                        "image": {
                          "imageUrl": "https://assets.coingecko.com/coins/images/28600/original/bonk.jpg?1696527587",
                          "cornerRadius": 99,
                          "width": 16,
                          "height": 16
                        }
                      }
                    },
                    {
                      "type": "coin",
                      "value": {
                        "id": 1,
                        "name": "BTC",
                        "marginBottom": 24,
                        "price": {
                          "value": 100.3,
                          "currency": "usd"
                        },
                        "image": {
                          "imageUrl": "https://assets.coingecko.com/coins/images/28880/original/0x0.png?1696527857",
                          "width": 16,
                          "height": 16,
                          "cornerRadius": 99
                        }
                      }
                    }
                  ]
                }
              }
            }
          }
        ]
      }
    }
  }
}
```
