//
//  ViewController.swift
//  iosApp
//
//  Created by jetbrains on 12/04/2018.
//  Copyright © 2018 JetBrains. All rights reserved.
//

import UIKit
//import sharedLib

class ViewController: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
//        let product = Factory().create(config: ["user": "JetBrains"])
//        label.text = product.description
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBOutlet weak var label: UILabel!
  
  override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
    return 10
  }
  
  override func numberOfSections(in tableView: UITableView) -> Int {
    return 1
  }
  
  override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
    let cell = tableView.dequeueReusableCell(withIdentifier: "item", for: indexPath)
    
    cell.textLabel?.text = "title"
    cell.detailTextLabel?.text = "dsd"
    
    return cell
  }
}

